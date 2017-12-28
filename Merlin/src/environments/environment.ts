// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.

export const environment = {
  production: false,
  envName: 'dev',
  url: "http://localhost:8085/",
  firebase:{
    apiKey: "AIzaSyD14JwBCjeTjUPxJrdIwpzI8sKfiKzXWTU",
    authDomain: "merlin-2a1ae.firebaseapp.com",
    databaseURL: "https://merlin-2a1ae.firebaseio.com",
    projectId: "merlin-2a1ae",
    storageBucket: "merlin-2a1ae.appspot.com",
    messagingSenderId: "735052292537"
  }
};
