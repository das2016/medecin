'use strict'
App.controller('rvController', [ '$scope', 'rvService' ,'clientService','medecinService',function($scope, rvService,clientService,medecinService) {
	console.log("Rv Controller .....................");
	$scope.rvs = [];
	$scope.rv = {date:'',idClient:null,idMedecin:null};
	$scope.clients = [];
	$scope.medecins=[];
	$scope.selectedClient = {id:'',titre:'',nom:'',prenom:'',dateNaissance:''};
	$scope.selectedMedecin = null;
	
	/**
	 * Get All Client
	 */
	var getAllClient = function getAllClient(){
		clientService.getAllClients().success(
				function(response) {
					$scope.clients = response;
					console.log("size client : "+$scope.clients.length)
				}).error(function(response) {
			console.log('Error getAllClient() Controller.........................');
		});
	}
	
	/**
	 * init all Client
	 */
	getAllClient();
	
	
	/**
	 * Get All Medecin
	 */
	var getAllMedecin = function getAllMedecin(){
		medecinService.gelAllMedecin().then(function(data) {
			$scope.medecins = data;
			console.log("size medecins : "+$scope.medecins.length)
		}, function(reason) {
			 console.error('Error while fetching Medecins');
		});
	}
	
	/**
	 * Init medecin List
	 */
	getAllMedecin();
	
	/**
	 * 
	 */
	$scope.showSelctedMedecin = function showSelctedMedecin(){
		console.log("show selected mededin  "+$scope.selectedMedecin);
	}
	
}]);