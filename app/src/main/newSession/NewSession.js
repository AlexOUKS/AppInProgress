import React, { Component } from 'react';
import axios from 'axios';
import { Button, Modal, ModalBody, ModalFooter, ModalHeader, Input, Row, Col, Progress } from 'reactstrap';
import './NewSession.css';

class NewSession extends Component {  

    constructor(props) {
        super(props);
        this.state = {
        }
    }

    render() {
        return (
            <div>
                <form>
                    <legend>Création d'un cours</legend>
                    <label for="code">Code : </label>
                    <input 
                        name="title"
                        placeholder="Code (4 lettres)"
                        maxLength="4"
                        required="required"
                        type="text"
                    /><br />
                    <label for="title">Titre : </label>
                    <input 
                        name="title"
                        placeholder="Titre du cours"
                        required="required"
                        type="text"
                    /><br />
                    <label for="desc">Description : </label>
                    <textarea 
                        name="desc"
                        placeholder="Description du cours"
                        required="required"
                        type="text"
                    /><br />
                    <button id="createCourse" >Créer le cours</button>
                </form>

                <form>
                    <legend>Création d'une session</legend>
                    <label for="code">Code : </label>
                    <input 
                        name="title"
                        placeholder="Code (4 lettres)"
                        maxLength="4"
                        required="required"
                        type="text"
                    /><br />
                    <button id="createSession" >Créer la session</button>
                </form>
            </div>
        )
    }
}

export default NewSession;