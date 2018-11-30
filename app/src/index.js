import React from 'react';
import ReactDOM from 'react-dom';
import Auth from './auth/Auth';
import './index.css';
require('dotenv').config()

if (sessionStorage.getItem('token')) {
    
} else {
    ReactDOM.render(<Auth />, document.getElementById('root'));
}
