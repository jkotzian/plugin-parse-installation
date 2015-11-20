var hello = {
    setUsernameForInstallationId: function(str, callback) {
    	cordova.exec(callback, function(err) {callback('Nothing here!');}, "Hello", "hello", [str]);
    }
}

module.exports = hello;
