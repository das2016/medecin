'use strict'
App.controller('rvController', [ '$scope', 'rvService' ,'clientService','medecinService',function($scope, rvService,clientService,medecinService) {
	console.log("Rv Controller .....................");
	$scope.rvs = [];
	$scope.rv = {jour:'',hDebut:'',hFin:'',mDebut:'',mFin:'',client:null,medecin:null};
	$scope.clients = [];
	$scope.medecins=[];
	$scope.selectedClient = {id:'',nom:'',prenom:'',adresse:'',dateNaissance:''};
	$scope.selectedMedecin = {id:'',nom:'',prenom:'',adresse:''};
	$scope.calendarOpened = false;
	
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
	 * Ajouter un nouveau rendez vous
	 */
	$scope.addNewRv = function addNewRv(rv){
		console.log("Add new rv minute debiut"+rv.mDebut+"  Heure de fin : "+rv.hFin);
		$scope.rv.client = $scope.selectedClient;
		$scope.rv.medecin = $scope.selectedMedecin;
		rvService.addRv(rv).success(function(data) {
			$scope.rv = null;
			$scope.selectedClient = null;
			$scope.selectedMedecin = null;
			$scope.newRvForm.$setPristine();
		}).error(function(data, status, headers, config) {
			console.log('Error when creating new Rv.........................');
		});
	}
	
	
	 function copyObjToObj(source, destination) {
	        if(!angular.equals(source,destination)){
	            if (!!destination) 
	                angular.copy(source, destination);
	            else 
	                destination = angular.copy(source);
	        }
	        return destination;
	    }
	
	
	/**
	 * 
	 */
	$scope.showSelectedMedecin = function showSelectedMedecin(){
		
		console.log("show selected mededin  "+$scope.selectedMedecin);
	}
	
	/**
	 * 
	 */
	$scope.showSelectedClient = function showSelectedClient(){
		console.log("show selected client  "+$scope.selectedClient);
	}
	
	/**
	 * Open calendar in popup update
	 */
	$scope.openCalendar = function($event) {
	    $event.preventDefault();
	    $event.stopPropagation();
	    $scope.calendarOpened = true;
	  };
}]);