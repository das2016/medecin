'use strict'
App.service('clientService', [ '$http', '$q', 'CLIENT_URL', function($http, $q,CLIENT_URL) {

	var clientService = {};
	var CLIENT_PATH = 'client';

	/**
	 * Get All Clients
	 * 
	 * @returns
	 */
	clientService.getAllClients = function() {
		return $http.get(CLIENT_URL+"clients").success(function(data) {
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
		return $http.post(CLIENT_URL+'addClient',client).success(function(data) {
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
		return $http.delete(CLIENT_URL+'deleteClient/'+client.id).success(function(data) {
			return data;
		}).error(function(data,status) {
			console.info('error when deleting client ******************!!!')
			console.log(data);
			console.log(status);
			});
	}
	
	
    /**
     * update Client
     */
	clientService.updateClient = function(client) {
		return $http.put(CLIENT_URL+'updateClient',client).success(function(data) {
			console.info('client '+client.nom+' is successfully updated');
			return data;
		}).error(function(data,status) {
			console.info('error when updating client ******************!!!')
			console.log(data);
			console.log(status);
			});
	}

	
return clientService;
	
} ]);