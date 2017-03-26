/**
 * Arnab
 */
RJN.controller('branchListCtrl', [ '$scope', '$http' , function ($scope, $http) {
	$scope.branchList = [];
	$scope.editBranch = {};
	$scope.displayAddForm = false;
	
	$scope.loadData = function() {
		$http.get(_context+'/admin/rest/branch-details').then(function(response) {
 			$scope.branchList = response.data.thisBranch;
 			console.log(response.data.thisBranch);
 		});
    };
    
    $scope.editForm = function(thisBranch) {
		$http.get(_context+'/admin/rest/edit-branch/' + thisBranch).then(function(response) {
 			$scope.editbranch = response.data.editBranch;
 			$scope.displayAddForm = true;
 			console.log(response.data.editBranch);
 		});
    };
    
    $scope.saveBranch = function(branch) {
		console.log(branch);
		$http.post(_context+'/admin/rest/register-branch', branch).then(function(response) {
			$scope.editCategory = {};
			toastr.success('Successfully Saved');
			$scope.displayAddForm = false;
			$scope.loadData();
		});
	};
    
    $scope.loadData();
	
}]);