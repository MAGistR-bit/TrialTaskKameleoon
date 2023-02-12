# №1. Build
FROM gradle:7.5.1-jdk17-alpine as builder

MAINTAINER mikhail

WORKDIR /source
COPY --chown=gradle:gradle build.gradle ./
COPY --chown=gradle:gradle settings.gradle ./
COPY --chown=gradle:gradle gradle.properties ./
COPY --chown=gradle:gradle src ./src/
RUN gradle --no-daemon --console=plain bootJar

# №2. Run
FROM openjdk:17.0.2-jdk-slim

MAINTAINER mikhail

ENV APP_ROOT /trialtask
RUN groupadd --gid 1111 --system trialtask \
    && useradd --uid 1111 --system --gid trialtask trialtask \
    && mkdir --parents ${APP_ROOT} \
    && chown --recursive trialtask:trialtask ${APP_ROOT}
USER trialtask
WORKDIR ${APP_ROOT}
COPY --chown=trialtask:trialtask --from=builder /source/build/libs/trialtask.jar ./
EXPOSE 8080
CMD ["java" , "-server", "-Xmx4G", "-Xms2G", "-jar", "trialtask.jar"]