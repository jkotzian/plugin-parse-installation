var hello = {
    getInstallationIdForUsername: function(str, callback) {
        cordova.exec(callback, function(err) {callback('Nothing to hello.');}, "Hello", "hello", [str]);
    },
    setUsernameForInstallationId: function(str, callback) {
    	cordova.exec(callback, function(err) {callback('Nothing here!');}, "Hello", "hey", [str]);
    }
}

module.exports = hello;