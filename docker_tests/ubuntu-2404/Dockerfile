FROM ubuntu:24.04
ENV JAVA_HOME=/opt/java/openjdk
COPY --from=eclipse-temurin:23 $JAVA_HOME $JAVA_HOME
ENV PATH="${JAVA_HOME}/bin:${PATH}"

COPY sample /opt/sample
COPY run_samples.sh /opt/run_samples.sh

RUN apt update && apt install --no-install-recommends --yes libvips-dev libvips-tools libjemalloc2
RUN vips --version

WORKDIR /opt
CMD ./run_samples.sh