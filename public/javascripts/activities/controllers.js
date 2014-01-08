/**
 * Created with IntelliJ IDEA.
 * User: dingziran
 * Date: 14-1-1
 * Time: 下午9:54
 * To change this template use File | Settings | File Templates.
 */

function CreateActivityCtrl($scope,$http){
    $scope.activity={};
    $scope.create=function(){
        $http.post("/activity",$scope.activity)
            .success(function(data){
            $scope.message=data;
                $http.get('/activity').success(function(data){
                    $scope.activities=data;
                });
        });
    };
    $scope.activities=[];
    $http.get('/activity').success(function(data){
        $scope.activities=data;
    });
}