// This file can be replaced during build by using the `fileReplacements` array.
// `ng build` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

const baseUrl =  `http://localhost:8080/`;
export const environment = {
  production: false,


  // State URLs
  addStateUrl: `${baseUrl}state/addState`,
  deleteStateUrl: `${baseUrl}state/deleteState/`,
  updateStateUrl: `${baseUrl}state/updateState/`,
  getStateUrl: `${baseUrl}state/`,
  getStatesUrl: `${baseUrl}state/allState`,

  // Zone URLs
  addZoneUrl: `${baseUrl}zone/addZone`,
  deleteZoneUrl: `${baseUrl}zone/deleteZone/`,
  updateZoneUrl: `${baseUrl}zone/updateZone/`,
  getZoneUrl: `${baseUrl}zone/`,
  getZoneByName: `${baseUrl}zone/zoneName/`,
  getZonesUrl: `${baseUrl}zone/allZone`,

  // Tax URLs
  addTaxUrl: `${baseUrl}tax/addTax`,
  deleteTaxUrl: `${baseUrl}tax/deleteTax/`,
  updateTaxUrl: `${baseUrl}tax/updateTax/`,
  getTaxUrl: `${baseUrl}tax/`,
  getTaxesUrl: `${baseUrl}tax/allTax`,

  // User
  addUserUrl: `${baseUrl}user/registerNerUser`,
  deleteUserUrl: `${baseUrl}user/deleteUser/`,
  updateUserUrl: `${baseUrl}user/UpdateUser/`,
  getUserUrl: `${baseUrl}user/`,
  getAllUsersUrl: `${baseUrl}user/getAllUser`,
  userAuthenticateUrl: `${baseUrl}authenticate`,
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/plugins/zone-error';  // Included with Angular CLI.
