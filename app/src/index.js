import React from 'react';
import ReactDOM from 'react-dom';
import Auth from './auth/Auth';
import Main from './main/Main';
import 'bootstrap/dist/css/bootstrap.min.css';
import './index.css';
require('dotenv').config()

if (sessionStorage.getItem('token')) {
    ReactDOM.render(<Main />, document.getElementById('root'));
} else {
    ReactDOM.render(<Auth />, document.getElementById('root'));
}
