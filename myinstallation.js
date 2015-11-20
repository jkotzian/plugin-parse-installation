var Installation = {
    setUsernameForInstallationId: function(str, callback) {
    	cordova.exec(callback, function(err) {callback('Nothing here!');}, "MyInstallation", "set", [str]);
    }
}

module.exports = Installation;
