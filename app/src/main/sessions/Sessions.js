import React, { Component } from 'react';
import axios from 'axios';

import './Sessions.css';

class Sessions extends Component {    
    constructor(props) {
        super(props);
        this.state = {
          sessions: []
        };
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
 
        sessions.forEach(element => {

            sessionsHtml.push(<tr onClick={element}>
                <td>*</td>
                <td>{element.location.city}</td>
                <td>{element.start_date}</td>
                <td>{element.end_date}</td>
                <td>{element.max_students}</td>
            </tr>);
            
        });
        
        this.setState({sessions : sessionsHtml});
    }
    render() {
        return(<table> 
                <thead>
                    <tr>
                        <th>Cours</th>
                        <th>Lieu</th>
                        <th>Date début</th>
                        <th>Date fin</th>
                        <th>Max. étudiants</th>
                    </tr>
                </thead>
                <tbody>
                    {this.state.sessions}
                </tbody>
            </table>)
    }
}


export default Sessions; 