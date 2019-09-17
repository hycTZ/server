# Dockerfile for apollo-adminservice
# 1. Copy apollo-adminservice-${VERSION}-github.zip to current directory
# 2. Build with: docker build -t apollo-adminservice .
# 3. Run with: docker run -p 8090:8090 -d -v /tmp/logs:/opt/logs --name apollo-adminservice apollo-adminservice

FROM openjdk:8-jre-alpine
MAINTAINER ameizi <sxyx2008@163.com>

ENV VERSION 1.0-SNAPSHOT
ENV SERVER_PORT 8080
# DataSource Info
ENV DS_URL ""
ENV DS_USERNAME ""
ENV DS_PASSWORD ""

RUN echo "http://mirrors.aliyun.com/alpine/v3.8/main" > /etc/apk/repositories \
    && echo "http://mirrors.aliyun.com/alpine/v3.8/community" >> /etc/apk/repositories \
    && apk update upgrade \
    && apk add --no-cache procps unzip curl bash tzdata \
    && ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo "Asia/Shanghai" > /etc/timezone

ADD server-${VERSION}.zip /server/server-${VERSION}.zip

RUN unzip /server/server-${VERSION}.zip -d /server \
    && rm -rf /server/server-${VERSION}.zip \
    && sed -i '$d' /server/scripts/startup.sh \
    && chmod +x /server/scripts/startup.sh \
    && echo "tail -f /dev/null" >> /server/scripts/startup.sh

EXPOSE $SERVER_PORT

CMD ["/server/scripts/startup.sh"]
