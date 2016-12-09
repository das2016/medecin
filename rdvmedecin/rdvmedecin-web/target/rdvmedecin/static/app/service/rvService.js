'use strict'
App.factory('rvService', [ '$http', '$q', 'RV_URL',
		function($http, $q, RV_URL) {

			/**
			 * method's factory
			 */
			var factory = {
				getAllRv : getAllRv
//				addRv : addRv,
//				updateRv : updateRv,
//				deleteRv : deleteRv
			};

			return factory;

			/**
			 * get all rv
			 */
			function getAllRv() {
				var defered = $q.defer;
				$http.get(RV_URL + "rvs").then(function(response) {
					deferred.resolve(response.data);
				}, function(errResponse) {
					console.error('Error while fetching Rendez vous');
					deferred.reject(errResponse);
				});
				return defered.promise;
			}

		} ]);
