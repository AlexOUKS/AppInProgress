import React, { Component } from 'react';
import axios from 'axios';
import { Button, Modal, ModalBody, ModalFooter, ModalHeader, Input, Row, Col, Progress } from 'reactstrap';
import './Sessions.css';

class Sessions extends Component {    
    constructor(props) {
        super(props);
        this.state = {
          sessions: [],
          sessionsHtml : [],
          modal : false,
          deletemodal : false,
          element : {},
          location : []
        };
        this.changeFilter = this.changeFilter.bind(this);
        this.getSessions();

    }

    getSessions() {
        axios.get(process.env.REACT_APP_API_URL+'/sessions', 
        {
          headers : {
            'Content-Type': 'application/x-www-form-urlencoded'
          }
        } 
        )
        .then(r => this.manageSessions(r.data));
    }

    
    
    manageSessions(sessions) {
        let sessionsHtml = [];
        let lieuxHtml = [];
        let lieux = [];

        sessions.forEach(element => {
            let inscrit = <Button color="success" onClick={this.toggle.bind(this, element)}>S'inscrire</Button>;
            let students = 0;
            if (element.students != null) {
                students = Object.keys(element.students).length;
                element.students.forEach(student => {
                    if ((Math.round((students / element.max_students) * 100) == 100)) {
                        inscrit = <b>Complet</b>
                    } else if (student == sessionStorage.getItem('id')) {
                        inscrit = <Button color="danger" onClick={this.unregistertoggle.bind(this, element)}>Se déinscrire</Button>;
                    } 
                });

                

            }

            if (!lieux.includes(element.location.city)) {
                lieux.push(element.location.city);
                lieuxHtml.push(<option>{element.location.city}</option>)
            }

            let dateStart = element.start_date.substring(0, element.start_date.indexOf('T'));
            let dateEnd = element.end_date.substring(0, element.end_date.indexOf('T'));

            sessionsHtml.push(<tr>
                <td>{element.course.code}</td>
                <td>{element.course.title}</td>
                <td>{element.course.description}</td>
                <td>{element.location.city}</td>
                <td>{dateStart}</td>
                <td>{dateEnd}</td>
                <td><Progress value={Math.round((students / element.max_students) * 100)} /> </td>
                <td>{inscrit}</td>
            </tr>);
            
        });
        this.setState({sessions : sessions,
                        location : lieuxHtml,
                        sessionsHtml : sessionsHtml});
        
    }
    getValues(event, field) {
        this.setState({
          [field]: event.target.value
        });
    }

    changeFilter(event) {
        this.filterSessions(event.target.value);
    }

    filterSessions(filter) {
        let sessionsHtml = [];
        if (typeof this.state.sessions != "undefined") {
            
            
            
            this.state.sessions.forEach(element => {
                let inscrit = <Button color="success" onClick={this.toggle.bind(this, element)}>S'inscrire</Button>;
                let students = 0;
                if (element.students != null) {
                    students = Object.keys(element.students).length;

                    element.students.forEach(student => {
                       
                        if ((Math.round((students / element.max_students) * 100) == 100)) {
                            inscrit = <b>Complet</b>
                        } else if (student == sessionStorage.getItem('id')) {
                            inscrit = <Button color="danger" onClick={this.unregistertoggle.bind(this, element)}>Se déinscrire</Button>;
                        } 
                    });

                   

                }

                
                let dateStart = element.start_date.substring(0, element.start_date.indexOf('T'));
                let dateEnd = element.end_date.substring(0, element.end_date.indexOf('T'));
                


                if (filter == "" || filter == null) {
                    sessionsHtml.push(<tr>
                        <td>{element.course.code}</td>
                        <td>{element.course.title}</td>
                        <td>{element.course.description}</td>
                        <td>{element.location.city}</td>
                        <td>{dateStart}</td>
                        <td>{dateEnd}</td>
                        <td><Progress value={Math.round((students / element.max_students) * 100)} /> </td>
                        <td>{inscrit}</td>
                    </tr>); 
                } else
                if ( (element.course.title.toLowerCase().indexOf(filter.toLowerCase()) !== -1) ) {
                    sessionsHtml.push(<tr>
                        <td>{element.course.code}</td>
                        <td>{element.course.title}</td>
                        <td>{element.course.description}</td>
                        <td>{element.location.city}</td>
                        <td>{dateStart}</td>
                        <td>{dateEnd}</td>
                        <td><Progress value={Math.round((students / element.max_students) * 100)} /> </td>
                        <td>{inscrit}</td>
                    </tr>);
                } else
                if ( (element.location.city.toLowerCase().indexOf(filter.toLowerCase()) !== -1) ) {
                    sessionsHtml.push(<tr>
                        <td>{element.course.code}</td>
                        <td>{element.course.title}</td>
                        <td>{element.course.description}</td>
                        <td>{element.location.city}</td>
                        <td>{dateStart}</td>
                        <td>{dateEnd}</td>
                        <td><Progress value={Math.round((students / element.max_students) * 100)} /> </td>
                        <td>{inscrit}</td>
                    </tr>);
                } 
                else
                if ( dateStart == filter) {
                    sessionsHtml.push(<tr>
                        <td>{element.course.code}</td>
                        <td>{element.course.title}</td>
                        <td>{element.course.description}</td>
                        <td>{element.location.city}</td>
                        <td>{dateStart}</td>
                        <td>{dateEnd}</td>
                        <td><Progress value={Math.round((students / element.max_students) * 100)} /> </td>
                        <td>{inscrit}</td>
                    </tr>);
                }

                
                
            });
            
            
            
               
        }
        
        
        this.setState({sessionsHtml : sessionsHtml});
    }
            
    toggle(element) {
        this.setState({
            modal: !this.state.modal,
            "element" : element
        });
    }

    unregistertoggle(element) {
        this.setState({
            deletemodal: !this.state.deletemodal,
            "element" : element
        });
    }

    

    
  toForm(details) {
    var formBody = [];
    for (var property in details) {
      var encodedKey = encodeURIComponent(property);
      var encodedValue = encodeURIComponent(details[property]);
      formBody.push(encodedKey + "=" + encodedValue);
    }
    formBody = formBody.join("&");
    return formBody;
  }

    


    register(element) {
        let form = this.toForm({'idSession' : element.id,
      'idUser' : sessionStorage.getItem('id')});

        this.toggle(element);
        axios.post(process.env.REACT_APP_API_URL+'/session/register', 
            form,
            {
            headers : {
                'Content-Type': 'application/x-www-form-urlencoded'
            }
            } 
            )
            .then(r => this.getSessions());
        
            
    }

    unregister(element) {
        let form = this.toForm({'idSession' : element.id,
      'idUser' : sessionStorage.getItem('id')});

        this.unregistertoggle(element);
        axios.post(process.env.REACT_APP_API_URL+'/session/unregister', 
            form,
            {
            headers : {
                'Content-Type': 'application/x-www-form-urlencoded'
            }
            } 
            )
            .then(r => this.getSessions());
        
            
    }
    

    
    render() {
        return(<div>
            <div>
                <Row>
                    <Col lg="3">
                        <Input type="select" onChange={this.changeFilter}  >
                            {this.state.location}
                        </Input>
                        </Col>
                        <Col lg="3"><Input type="date" onChange={this.changeFilter}  /></Col>
                        <Col lg="3"><Input onChange={this.changeFilter} placeholder="Titre du cours"  /></Col>  
                </Row>
            </div>
            <table> 
                <thead>
                    <tr>
                        <th>Code</th>
                        <th>Titre du code</th>
                        <th>Description</th>
                        <th>Lieu</th>
                        <th>Date début</th>
                        <th>Date fin</th>
                        <th>% étudiants inscrits</th>
                        <th>Inscription</th>
                    </tr>
                </thead>
                <tbody>
                    {this.state.sessionsHtml}
                </tbody>
            </table>
            <div>   
                <Modal isOpen={this.state.modal} toggle={this.toggle}>
                <ModalHeader toggle={this.toggle}>Inscription</ModalHeader>
                <ModalBody>
                   Voulez-vous vous inscrire dans ce cours ?
                </ModalBody>
                <ModalFooter>
                    <Button color="success" onClick={this.register.bind(this, this.state.element)}>S'inscrire</Button>{' '}
                    <Button color="secondary" onClick={this.toggle.bind(this, this.state.element)}>Annuler</Button>
                </ModalFooter>
                </Modal>

                <Modal isOpen={this.state.deletemodal} toggle={this.unregistertoggle}>
                <ModalHeader toggle={this.unregistertoggle}>Désinscription</ModalHeader>
                <ModalBody>
                    Voulez-vous vous déinscrire de ce cours ?
                </ModalBody>
                <ModalFooter>
                    <Button color="danger" onClick={this.unregister.bind(this, this.state.element)}>Se désinscrire</Button>{' '}
                    <Button color="secondary" onClick={this.unregistertoggle.bind(this, this.state.element)}>Annuler</Button>
                </ModalFooter>
                </Modal>
          </div></div>)
    }

    
}


export default Sessions; 