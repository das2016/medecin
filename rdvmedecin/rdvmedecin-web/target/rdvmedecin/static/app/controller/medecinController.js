'use strict'
App.controller('medecinController',['medecinService','$scope', function(medecinService,$scope) {
	
	$scope.medecins = [];
	$scope.medecin = {id:null,nom:'',prenom:'',adresse:'',numTel:''};
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
	
	/**
	 * Add Medecin
	 */
	$scope.addNewMedecin = function addNewMedecin(medecin) {
		medecinService.addMedecin(medecin).then(function(data) {
			$('#addMedecinMsg').show(0).delay(2500).hide(0);
			getAllMedecin();
			$scope.medecin = null;
			$scope.newMedecinForm.$setPristine();
	}, function(reason) {
		console.log('Error when creating new Medecin.........................');
	});
	}
	
	/**
	 * Open POpup selected Medecin
	 */
	$scope.openPopupUpdateMedecin = function openPopupUpdateMedecin(medecin){
		$scope.selectedMedecin = angular.copy(medecin);
		$('#updateMedecin').modal('show');
		console.log('open popup update medecin');
	}
	
	/**
	 * Open delete dialog
	 */
	$scope.openPopupDeletMedecin = function openPopupDeletMedecin(medecin) {
		$scope.selectedMedecin = angular.copy(medecin)
		$('#deleteMedecin').modal('show');
		console.log('open delete dialog');
	}
	
	/**
	 * Delete medecin 
	 */
	$scope.deleteMedecin = function deleteMedecin(medecin){
		medecinService.deleteMedecin(medecin).then(function(data) {
			getAllMedecin();
			$('#deleteMedecinMsg').show(0).delay(2500).hide(0);	
			$('#deleteMedecin').modal('hide');
		}, function(reason) {
			$('#deleteMedecinMsgError').show(0).delay(2500).hide(0);	
		});
	}
	
	/**
	 * Update Medecin
	 */
	$scope.updateMedecin = function updateMedecin(selectedMedecin) {
		console.log("update -------------------- medecin : "+selectedMedecin.nom);
		medecinService.updateMedecin(selectedMedecin).then(function(data) {
			getAllMedecin();
			$('#updateMedecintMsg').show(0).delay(2500).hide(0);
			$('#updateMedecin').modal('hide');
		}, function(reason) {
			$('#updateMedecintMsgError').show(0).delay(2500).hide(0);
			console.log('Error updating medecin Controller.........................'+reason);
		});
	}
	
	
}]);