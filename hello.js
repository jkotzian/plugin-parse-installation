var hello = {
    world: function(str, callback) {
        cordova.exec(callback, function(err) {callback('Nothing to hello.');}, "Hello", "hello", [str]);
    }
    setUserWithInstallation: function(str, callback) {
    	cordova.exec(callback, function(err) {callback('Nothing here!');}, "Hello", "hey", [str]);
    }
}

module.exports = {hello, hey};