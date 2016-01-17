var instsApp = angular.module("insts-app", []);
instsApp.controller('instsController', function ($scope, $http) {
   /* $http.get('http://localhost:33094/SpringJSF/rest/insts/')
            .success(function (data) {
                alert(data);
                $scope.instsList = data;
            }); */
    $scope.add = function() {
        var inst = {"name":$scope.inst.iname, "type":$scope.inst.itype};
        var resp = $http.post('http://localhost:33094/SpringJSF/rest/insts/add', inst);
        resp.success(function(data, status, headers, config) {
            $scope.message = 'SUCCESS';
        });
        resp.error(function(data, status, headers, config) {
            $scope.message = 'FAILURE';
        });
    };
});