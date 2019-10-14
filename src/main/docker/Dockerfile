FROM store/oracle/database-enterprise:12.2.0.1-slim

ADD ./scripts/initdb.sh /home/oracle/setup
ADD ./scripts/ddl.sql /scripts/sql/

HEALTHCHECK --interval=10s --timeout=5m --start-period=3m --retries=30 \
CMD /bin/bash /home/oracle/setup/healthcheck.sh

