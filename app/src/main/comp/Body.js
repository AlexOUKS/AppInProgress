import React, { Component } from 'react';

class Body extends Component {
    constructor(props) {
        super(props);
        this.state = {
          page: props.page
        };
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
                <h2>Content sessions</h2>
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