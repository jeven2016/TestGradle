FROM oraclelinux
MAINTAINER Haoming Chu, haoming.chu@oracle.com

RUN mkdir -p /opt/tb && \
    mkdir -p /var/slc/

# install jdk rpm
RUN export http_proxy=http://cn-proxy.jp.oracle.com:80 && \
    export https_proxy=http://cn-proxy.jp.oracle.com:80 && \
    curl -L -b "oraclelicense=a" http://download.oracle.com/otn-pub/java/jdk/8u161-b12/2f38c3b165be4555a1fa6e98c45e0808/jdk-8u161-linux-x64.rpm -o /tmp/jdk.rpm && \
    yum -y install /tmp/jdk.rpm

# change the default jvm settings
RUN alternatives --install /usr/bin/java jar /usr/java/latest/bin/java 200000
RUN alternatives --install /usr/bin/javaws javaws /usr/java/latest/bin/javaws 200000
RUN alternatives --install /usr/bin/javac javac /usr/java/latest/bin/javac 200000

#clear the unused files
RUN rm -f /tmp/jdk.rpm

ENV JAVA_HOME /usr/java/latest
ENV PATH $PATH:$JAVA_HOME/bin

ADD run.sh /opt/tb/run.sh
ADD slc-backend.jar /var/slc/slc-backend.jar
RUN chmod a+x /opt/tb/run.sh

# EXPOSE 8000

ENTRYPOINT ["/opt/tb/run.sh"]