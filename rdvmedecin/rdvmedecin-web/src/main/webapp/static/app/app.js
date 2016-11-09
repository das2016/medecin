'use strict';
var App = angular.module('rdvmedecins', [ 'ui.router', 'ui.bootstrap']);

App.config(
		function($stateProvider, $urlRouterProvider, $locationProvider,
				$httpProvider) {
			 $urlRouterProvider.otherwise('/');
			$stateProvider.
			}).state('home', {
				url : '/home',
				templateUrl : 'static/views/home.html'
//				parent : 'main'
			}).state('client', {
				url : '/client',
				templateUrl : 'static/views/secure/client.html',
				controller : 'testController'
//				parent : 'main'
			}).state('medecin', {
				url : '/medecin',
				templateUrl : 'static/views/secure/medecin.html',
				controller : 'testController'
			});
		});
