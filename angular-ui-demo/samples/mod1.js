/**
 * http://usejsdoc.org/
 */
var express = require('express');
var router = express.Router();

var app = express();

// middleware that is specific to this router
router.use(function(req, res, next) {
  console.log("Constant Key :: " +  req.app.locals.secret);
  console.log('Time: ', Date.now());
  next();
});

// define the home page route
router.get('/', function(req, res) {
  res.send('Root/home page');
});

// define the about route
router.get('/about', function(req, res) {
  res.send('About Page');
});

module.exports = router;