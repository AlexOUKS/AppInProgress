import React, { Component } from 'react';
import Sessions from '../sessions/Sessions';

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
                <h2>Content home</h2>
            )
        }
        if(page == "courses")
        {
            return(
                <h2>Content courses</h2>
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