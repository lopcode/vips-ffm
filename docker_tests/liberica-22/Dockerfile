FROM bellsoft/liberica-openjre-debian:22
WORKDIR /app

COPY sample /app/sample
COPY run_samples.sh /app/run_samples.sh

RUN apt-get update -y && \
    apt-get install -y --no-install-recommends \
        libvips-dev \
        libvips-tools \
        libwebp-dev && \
    rm -rf /var/lib/apt/lists/*

RUN vips --version
CMD ./run_samples.sh