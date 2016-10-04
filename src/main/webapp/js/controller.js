/**
 * Created by michael on 04.10.16.
 */
var coffeeController = app.controller("CoffeeController", ["$http", function($http){
    this.title="works";
    this.makeSmall = function () {
        $http({
            method: "GET",
            url: "http://localhost:8080/api/coffee/1"
        }).then(function successCallback(response) {
            alert(response.data);
        }, function errorCallback(response) {
            alert(response.data);
        });
    };
    this.makeLarge = function () {
        $http({
            method: "GET",
            url: "http://localhost:8080/api/coffee/2"
        }).then(function successCallback(response) {
            alert(response.data);
        }, function errorCallback(response) {
            alert(response.data);
        });
    };
}]);