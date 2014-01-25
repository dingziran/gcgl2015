/**
 * Created with IntelliJ IDEA.
 * User: dingziran
 * Date: 14-1-1
 * Time: 下午9:54
 * To change this template use File | Settings | File Templates.
 */

function CreateActivityCtrl($scope,$http,$log){
    $scope.activity={};

    $scope.isCreated=false;
    $scope.create=function(){

        $log.debug($scope.activity);
        $http.post("/activity",$scope.activity)
            .success(function(data){
                $scope.message=data;
                $http.get('/activity').success(function(data){
                    $scope.activities=data;
                });
            });
    };
    $scope.showCreate=function(){
        $scope.isCreated=!$scope.isCreated;
    };
    $scope.delete=function(input){
        $log.debug(input);
        var activity={}
        activity.id=input._id.$oid
        $log.debug(activity);
        $http.delete("/activity",{data:activity,headers:{"Content-Type":"application/json;charset=UTF-8"}})
            .success(function(data){
                $http.get('/activity').success(function(data){
                    $scope.activities=data;
                });
            })
    }
    $scope.activities=[];
    $http.get('/activity').success(function(data){
        $scope.activities=data;
    });
}