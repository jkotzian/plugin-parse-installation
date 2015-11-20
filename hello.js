var hello = {
    setUsernameForInstallationId: function(str, callback) {
    	cordova.exec(callback, function(err) {callback('Nothing here!');}, "MyInstallation", "hello", [str]);
    }
}

module.exports = hello;
