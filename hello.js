var installation = {
    setUsernameForInstallationId: function(str, callback) {
    	cordova.exec(callback, function(err) {callback('Nothing here!');}, "MyInstallation", "installation", [str]);
    }
}

module.exports = installation;
