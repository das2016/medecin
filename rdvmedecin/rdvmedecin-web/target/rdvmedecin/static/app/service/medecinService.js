'use strict'
App.factory('medecinService', [ '$http', '$q', 'MEDECIN_URL',
		function($http, $q, MEDECIN_URL) {

			/**
			 * factory method's
			 */
			var factory = {
				gelAllMedecin : getAllMedecin,
				addMedecin : addMedecin,
				updateMedecin : updateMedecin,
				deleteMedecin : deleteMedecin
			};

			return factory;

			/**
			 * Get all medecin
			 */
			function getAllMedecin() {
				var deferred = $q.defer();
				$http.get(MEDECIN_URL+'medecins').then(function(response) {
					deferred.resolve(response.data);
				}, function(errResponse) {
					console.error('Error while fetching Medecins');
					deferred.reject(errResponse);
				});
				return deferred.promise;
			}

			/**
			 * Add medecin
			 */
			function addMedecin(medecin) {
				var deferred = $q.defer();
				$http.post(MEDECIN_URL+'addMedecin', medecin).then(function(response) {
					deferred.resolve(response.data);
				}, function(errResponse) {
					console.error("Error while adding medecin");
					deferred.reject(errResponse);
				});
				return deferred.promise;
			}

			/**
			 * Update medecin
			 */
			function updateMedecin(medecin) {
				var deferred = $q.defer();
				$http.put(MEDECIN_URL+'updateMedecin', medecin).then(function(response) {
					deferred.resolve(response.data);
				}, function(errResponse) {
					console.log("Error while updating medecin");
					deferred.reject(errResponse);
				});
				return deferred.promise;
			}
			
			/**
			 * Delete medecin
			 */
			function deleteMedecin(medecin) {
				var deferred = $q.defer();
				$http.delete(MEDECIN_URL+'deleteMedecin/'+medecin.id).then(function(response) {
					deferred.resolve(response.data);
				}, function(errResponse) {
					console.log('Error while deleteing Medecin');
					deferred.reject(errResponse);
				});
				return deferred.promise;
			}

		} ]);