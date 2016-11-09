'use strict'
App.controller('testController', [ '$scope', 'clientService',function($scope, clientService) {
	console.info('Client Controller *****************************************');
	var self = this;
	$scope.client = {id:'',titre:'',nom:'',prenom:'',dateNaissance:''};
	$scope.selectedClient = null;
	$scope.clients = [];
	
//	/**
//	 * init all client
//	 */
//	getAllClient();
	
	/**
	 * Open popup new Client
	 */
	$scope.openPopupNewClient =function openPopupNewClient(){
		console.log('Open popup add new client ........')
		$('#addNewClient').modal('show');
	}
	
	/**
	 * Add New Client
	 */
	$scope.addNewClient = function addNewClient(client){
		clientService.addClient(client).success(function(data) {
			$('#addNewClient').modal('hide');
			/*
			 * refreshing the datable without getting select method to the database
			 */
//			$scope.clients.push(client);
			getAllClient();
			$('#addClientMsg').show(0).delay(2500).hide(0);
			$scope.client = null;
			$scope.newClientForm.$setPristine();
		}).error(function(data, status, headers, config) {
			console.log('Error when creating new Client.........................');
		});
	}
	
	/**
	 * Open popup delete client
	 */
	$scope.openPopupDeletClient = function openPopupDeletClient(client){
		$scope.selectedClient = client;
		$('#deleteClient').modal('show');
	}
	
	/**
	 * Delete Client
	 */
	$scope.deleteClient = function deleteClient(selectedClient){
		console.log('delete the selected client '+selectedClient.nom);
		clientService.deleteClient(selectedClient).success(function(data) {
		    initDeleteClientTable(selectedClient);
		    $('#deleteClientMsg').show(0).delay(2500).hide(0);
			return data;
		}).error(function(data, status) {
			 $('#deleteClientMsgError').show(0).delay(3000).hide(0);
			console.log('Error deleting client Controller.........................');
		});
		$('#deleteClient').modal('hide');
	}
	
	/**
	 * Init Table after deleting
	 */
	var initDeleteClientTable = function(selectedClient){
		for(var i=0;i<$scope.clients.length;i++){
			if($scope.clients[i].id == selectedClient.id){
				$scope.clients.splice(i, 1);
				break;
			}
		}
	}
	
	
	/**
	 * Init Table after deleting
	 */
	var initUpdateClientTable = function(selectedClient){
		for(var i=0;i<$scope.clients.length;i++){
			if($scope.clients[i].id == selectedClient.id){
				$scope.clients.splice(i, selectedClient);
				break;
			}
		}
	}
	
	/**
	 * Open popup update client
	 */
	$scope.openPopupUpdateClient = function openPopupUpdateClient(client){
		$scope.selectedClient = angular.copy(client);
		$scope.header = client.nom;
		$('#updateClient').modal('show');
		console.log('open popu update client');
	}
	
	/**
	 * update Client
	 */
	$scope.updateClient = function updateClient(selectedClient){
		console.log("update -------------------- client : "+selectedClient.nom);
		clientService.updateClient(selectedClient).success(function(data) {
			$('#updateClient').modal('hide');
			getAllClient();
			return data;
		}).error(function(data, status) {
			console.log('Error updating client Controller.........................');
		});
	}
	
	/**
	 * Get All Client
	 */
	var getAllClient = function getAllClient(){
		clientService.getAllClients().success(
				function(response) {
					$scope.clients = response;
				}).error(function(response) {
			console.log('Error getAllClient() Controller.........................');
		});
	}
	
	getAllClient();
	
	
	$scope.open = function($event) {
	    $event.preventDefault();
	    $event.stopPropagation();

	    $scope.opened = true;
	  };
//
//	  $scope.dateOptions = {
//	    'year-format': "'yy'",
//	    'starting-day': 1
//	  };

//	  $scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'shortDate'];
//	  $scope.format = $scope.formats[0];
	
		} ])
