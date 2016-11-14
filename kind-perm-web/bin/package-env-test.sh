#!bin/sh

cd ../../kind-perm-core

mvn clean
mvn install
echo "kind-perm-core install success."

cd ../kind-perm-web

mvn clean
mvn package -Ptest -Dmaven.tests.failure.ignore=true