import React, { Component } from 'react';
import axios from 'axios';
import { Alert, Label,Button, Modal, ModalBody, ModalFooter, ModalHeader, Input, Row, Col, Progress } from 'reactstrap';
import './NewSession.css';
import Validators from '../../validators/validators'

class NewSession extends Component {  

    constructor(props) {
        super(props);
        this.state = {
                locations:[],
                courses:[],
                courseCode:"",
                courseTitle:"",
                courseDesc:"",
                courseError: "",
                sessionError: "",
                sessionBegDate:"",
                sessionEndDate:"",
                sessionCode:"",
                sessionMaxStud:"",
                sessionLocID:""
            
        }
        this.getValues = this.getValues.bind(this);

        this.getCourses();
        this.getLocations();
    }
    getValues(event, field) {
        this.setState({
          [field]: event.target.value
        });
    }

    getLocations() {
        axios.get(process.env.REACT_APP_API_URL+'/locations', 
        {
          headers : {
            'Content-Type': 'application/x-www-form-urlencoded'
          }
        } 
        )
        .then(r => this.manageLocations(r.data));
    }

    getCourses() {
        axios.get(process.env.REACT_APP_API_URL+'/courses', 
        {
          headers : {
            'Content-Type': 'application/x-www-form-urlencoded'
          }
        } 
        )
        .then(r => this.manageCourses(r.data));
    }

    manageLocations(response){
        let htmlValue =  [];
        response.forEach(element => {
            htmlValue.push(<option value={element.id}>{element.city}</option>);
        })
        this.setState({locations:htmlValue})
    }
    manageCourses(response){
        let htmlValue =  [];
        response.forEach(element => {
            htmlValue.push(<option value={element.code}>{element.code}</option>);
        })
        this.setState({courses:htmlValue})
    }
    
    sendNewCourse()
    {
        let fields = {
            code: this.state.courseCode,
            title:this.state.courseTitle,
            desc: this.state.courseDesc
        }

        let isValid = Validators.fields_not_empty(fields);

        if(isValid === true)
        { 
            let form = this.toForm( {
                'code' : this.state.courseCode,
                'title' : this.state.courseTitle, 
                'desc' : this.state.courseDesc
            });
            axios.post(process.env.REACT_APP_API_URL+'/course/add', 
            form,
            {
                headers : {
                    'Content-Type': 'application/x-www-form-urlencoded',
                    'authtoken' : sessionStorage.getItem('token')
                }
            } 
            )
            .then(r => {
                this.setState({courseError:false});
                this.getCourses();
            })
            .catch((r) => {
                this.setState({courseError:true});
            });
            
        }
        else{
            this.setState({courseError:true});
        }
    }
    sendNewSession()
    {
        let fields = {
            courseID: this.state.sessionCode,
            locationID:this.state.sessionLocID,
            start_date:this.state.sessionBegDate,
            end_date:this.state.sessionEndDate,
            max_student:this.state.sessionMaxStud
        }

        console.log(fields);
        let isValid = Validators.fields_not_empty(fields);

        if(isValid === true)
        { 
            console.log("ok");
            let form = this.toForm( {
                "courseID": this.state.sessionCode,
                "locationID":this.state.sessionLocID,
                "start_date":this.state.sessionBegDate,
                "end_date":this.state.sessionEndDate,
                "max_student":this.state.sessionMaxStud
            });
            axios.post(process.env.REACT_APP_API_URL+'/session/add', 
            form,
            {
                headers : {
                    'Content-Type': 'application/x-www-form-urlencoded',
                    'authtoken' : sessionStorage.getItem('token')
                }
            } 
            )
            .then(r => {
                console.log("ok2");
                this.setState({sessionError:false});
            })
            .catch((r) => {
                console.log("o3");
                this.setState({sessionError:true});
            });
            
        }
        else{
            this.setState({sessionError:true});
        }
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
    render() {
        return (
            <div>
                {
                    this.state.courseError === true ? 
                    <Alert color="danger" > Erreur lors de la création du cours.</Alert> : 
                    ""
                }

                {
                    this.state.courseError === false ?  
                    <Alert color="success" >Le cours a été créé.</Alert> : 
                    "" 
                }
                {
                    this.state.sessionError === true ? 
                    <Alert color="danger" > Erreur lors de la création de la session.</Alert> : 
                    ""
                }

                {
                    this.state.sessionError === false ?  
                    <Alert color="success" >La session a été créée.</Alert> : 
                    "" 
                }
                <form>
                    <legend>Création d'un cours</legend>
                    <Label for="code">Code : </Label>
                    <Input 
                        name="title"
                        placeholder="Code (4 lettres)"
                        maxLength="4"
                        required="required"
                        type="text"
                        onChange={evt => this.getValues(evt, 'courseCode')}
                    /><br />
                    <Label for="title">Titre : </Label>
                    <Input 
                        name="title"
                        placeholder="Titre du cours"
                        required="required"
                        type="text"
                        onChange={evt => this.getValues(evt, 'courseTitle')}
                    /><br />
                    <Label for="desc">Description : </Label>
                    <Input 
                        name="desc"
                        placeholder="Description du cours"
                        required="required"
                        type="textarea"
                        onChange={evt => this.getValues(evt, 'courseDesc')}
                    /><br />
                    <Button id="createCourse" onClick={this.sendNewCourse.bind(this)} >Créer le cours</Button>
                </form>

                <form>
                    <legend>Création d'une session</legend>
                    <Label for="locations">Lieu de la session :</Label>
                    <Input type="select" name="locations"
                        onChange={evt => this.getValues(evt, 'sessionLocID')}>
                        {this.state.locations}
                    </Input>
                    <Label for="courses">Cours :</Label>
                    <Input type="select" name="courses"
                        onChange={evt => this.getValues(evt, 'sessionCode')}>
                        {this.state.courses}
                    </Input>
                    <Label for="begin_date">Date de début :</Label>
                    <Input 
                        name="begin_date"
                        placeholder="ex : 01/01/2018"
                        required="required"
                        type="date"
                        onChange={evt => this.getValues(evt, 'sessionBegDate')}
                    />
                    <Label for="end_date">Date de fin :</Label>
                    <Input 
                        name="end_date"
                        placeholder="ex : 31/12/2018"
                        required="required"
                        type="date"
                        onChange={evt => this.getValues(evt, 'sessionEndDate')}
                    />
                    <Label for="max_stud">Maximum d'étudiants :</Label>
                    <Input 
                        name="max_stud"
                        placeholder="ex : 30"
                        required="required"
                        type="number"
                        onChange={evt => this.getValues(evt, 'sessionMaxStud')}
                    />
                    <Button id="createSession" onClick={this.sendNewSession.bind(this)} >Créer la session</Button>
                </form>
            </div>
        )
    }
}

export default NewSession;