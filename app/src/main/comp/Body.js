import React, { Component } from 'react';
import Sessions from '../sessions/Sessions';
import NewSession from '../newSession/NewSession';

class Body extends Component {
    constructor(props) {
        super(props);
        this.state = {
          page: props.page
        };
    }

    componentDidMount() {
        this.setState({page : this.props.page})
      }

    componentDidUpdate(prevProps) {
        if(this.props.page != this.state.page) 
        {
               this.componentDidMount();
        }
    } 

    render() {
        var page = this.state.page;
        if(page == "home")
        {
            return(
                <NewSession />
            )
        }

        if(page == "sessions")
        {
            return(
                <Sessions />
            )
        }
        else{
            return (
                <h2>404 not found</h2>
            )
        }
    }
}


export default Body; 