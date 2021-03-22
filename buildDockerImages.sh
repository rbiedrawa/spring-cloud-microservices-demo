echo 'admin-dashboard - Build started'
cd ./applications/admin-dashboard && sh gradlew clean jibDockerBuild && cd ../..
echo 'admin-dashboard - Build completed'

echo 'api-gateway - Build started'
cd ./applications/api-gateway && sh gradlew clean jibDockerBuild && cd ../..
echo 'api-gateway - Build completed'

echo 'config-server - Build started'
cd ./applications/config-server && sh gradlew clean jibDockerBuild && cd ../..
echo 'config-server - Build completed'

echo 'service-registry - Build started'
cd ./applications/service-registry && sh gradlew clean jibDockerBuild && cd ../..
echo 'service-registry - Build completed'

echo 'hello-service - Build started'
cd ./applications/services/hello-service && sh gradlew clean jibDockerBuild && cd ../../..
echo 'hello-service - Build completed'

echo 'user-service - Build started'
cd ./applications/services/user-service && sh gradlew clean jibDockerBuild && cd ../../..
echo 'user-service - Build completed'

