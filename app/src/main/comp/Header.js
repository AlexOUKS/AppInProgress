import React, { Component } from 'react';
import './Header.css';

class Header extends Component {

    constructor(props) {
        super(props);
        this.state = {
          crumbs : props.crumbs
        };
    }

    crumbs() {
        console.log(this.props.crumbs);
        let htmlBuffer = [];
        this.state.crumbs.forEach(element => {
            console.log(element);
            htmlBuffer.push(<li class="crumb">{element}</li>);
        });

        this.setState({crumbs : htmlBuffer});
    }

    render() {
        return (
            <header>
                <h1>Vinksel Corp.</h1>
                <nav id="navigationMenu">
                    
                </nav>
                <nav id="breadCrumb">
                    <ol>
                        {this.state.crumbs}
                    </ol>
                </nav>
            </header>
        );
    }
}



export default Header; 