cd ../../kind-perm-core

call mvn clean
call mvn install
@echo kind-perm-core install success.

cd ../kind-perm-web
call mvn clean
call mvn package -Dmaven.tests.failure.ignore=true
call mvn jetty:run

@pause