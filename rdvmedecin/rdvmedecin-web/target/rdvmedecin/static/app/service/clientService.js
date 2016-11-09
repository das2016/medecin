'use strict'
App.service('clientService', [ '$http', '$q', function($http, $q) {

	var clientService = {};
	var CLIENT_PATH = 'client';

	/**
	 * Get All Clients
	 * 
	 * @returns
	 */
	clientService.getAllClients = function() {
		return $http.get("http://localhost:8080/rdvmedecin/client/clients").success(function(data) {
			console.info('Get all client service !!!!!!!!!!!!!!!!!!!!!!!')
			return data;
		}).error(function(data, status) {
			console.info('error Get all client service ******************!!!')
			console.log(data);
			console.log(status);
		});
	}
	
	
	/**
	 * Add New Client
	 * 
	 * @param client
	 * @returns
	 */
	clientService.addClient = function(client) {
		return $http.post('http://localhost:8080/rdvmedecin/client/addClient',client).success(function(data) {
			console.info('client '+client.nom+' is successfully added');
			return data;
		}).error(function(data,status) {
			console.info('error when adding new client ******************!!!')
			console.log(data);
			console.log(status);
			});
	}
	
	
	/**
	 * Delete Client
	 * 
	 * @param client
	 * @returns
	 */
	clientService.deleteClient = function(client) {
		return $http.delete('http://localhost:8080/rdvmedecin/client/deleteClient/'+client.id).success(function(data) {
			return data;
		}).error(function(data,status) {
			console.info('error when deleting client ******************!!!')
			console.log(data);
			console.log(status);
			});
	}
	
	
     /**
      * updateClient
      */
	clientService.updateClient = function(client) {
		return $http.put('http://localhost:8080/rdvmedecin/client/updateClient',client).success(function(data) {
			console.info('client '+client.nom+' is successfully updated');
			return data;
		}).error(function(data,status) {
			console.info('error when updating client ******************!!!')
			console.log(data);
			console.log(status);
			});
	}

// clientService.getAll = function() {
// return $http.get(API_PATH + '/clients').then(function(response) {
// return response.data;
// }, function(errResponse) {
// console.error('Error while fetching clients');
// return $q.reject(errResponse);
// });
// }
	
return clientService;
	
} ]);