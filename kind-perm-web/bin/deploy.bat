cd ..
call mvn clean deploy -Dmaven.tests.failure.ignore=true
@pause