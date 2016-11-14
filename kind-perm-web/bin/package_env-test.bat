cd ../../kind-perm-core

call mvn clean
call mvn install
@echo kind-perm-core install success.

cd ../kind-perm-web
call mvn clean
call mvn package -Ptest -Dmaven.tests.failure.ignore=true
@pause