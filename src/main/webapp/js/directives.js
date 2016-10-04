/**
 * Created by michael on 04.10.16.
 */
var makeCoffeeDirective = app.directive("makeCoffee", function(){
    return{
        restrict: 'E',
        templateUrl: 'makeCoffee.html'
    };
});