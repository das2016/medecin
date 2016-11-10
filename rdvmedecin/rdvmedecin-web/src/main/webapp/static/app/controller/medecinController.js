'use strict'
App.controller('medecinController',['medecinService','$scope', function(medecinService,$scope) {
	
	$scope.medecins = [];
	$scope.medecin = {id:null,nom:'',prenom:'',tittre:''};
	$scope.selectedMedecin = null;
	
	/**
	 * Get All Medecin
	 */
	var getAllMedecin = function getAllMedecin(){
		medecinService.gelAllMedecin().then(function(data) {
			$scope.medecins = data;
		}, function(reason) {
			 console.error('Error while fetching Medecins');
		});
	}
	/**
	 * Init medecin List
	 */
	getAllMedecin();
	
	
}]);