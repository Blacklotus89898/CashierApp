import PropTypes from 'prop-types';

const Container = ({ children, ...props }) => {
    return (
        <>
        <div {...props} style={{border: "4px solid black", flexGrow: 1, borderRadius:"15px"}}> 
            {children}
        </div>
        </>
    );
};

Container.propTypes = {
    children: PropTypes.node.isRequired,
};

export default Container;