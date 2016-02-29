/**
 * http://usejsdoc.org/
 */
var passport = require('passport');
var LocalStrategy = require('passport-local').Strategy;



passport.use(new LocalStrategy(function(username, password, done) {
	if (username !== 'mean') {
		return done(null, false, {
			message : 'Incorrect username.'
		});
	}
	if (password !== '12345') {
		return done(null, false, {
			message : 'Incorrect password.'
		});
	}
	return done(null, {'username':'mean', 'password':'12345'});
}));
