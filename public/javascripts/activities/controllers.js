/**
 * Created with IntelliJ IDEA.
 * User: dingziran
 * Date: 14-1-1
 * Time: 下午9:54
 * To change this template use File | Settings | File Templates.
 */

function CreateActivityCtrl($scope,$http){
    $scope.count=0;
    $scope.activity={};
    $scope.create=function(){
        this.count=this.count+1;
        $http.post("http://localhost:9000/activity",$scope.activity)
            .success(function(data){
            $scope.message=data;
        })
    };
}