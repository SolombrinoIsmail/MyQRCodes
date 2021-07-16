import React, {useState} from 'react';
import {COLORS, SIZES, FONTS, icons, images} from "../constants"
import {
    KeyboardAvoidingView,
    StyleSheet,
    Text,
    View,
    TextInput,
    TouchableOpacity,
    Keyboard,
    ScrollView,
    Alert
} from 'react-native';
import Task from '../components/Task';
import * as Haptics from "expo-haptics";

export default function ListTodo() {
    const [task, setTask] = useState();
    const [taskItems, setTaskItems] = useState([]);

    const handleAddTask = () => {
        if (!task) {
            Alert.alert(
                "Empty!",
                "Please enter something to do")
            return;
        }
        Keyboard.dismiss();
        setTaskItems([...taskItems, task])
        setTask(null);
    }

    const completeTask = (index) => {
        let itemsCopy = [...taskItems];
        itemsCopy.splice(index, 1);
        setTaskItems(itemsCopy)
    }
    const createTwoButtonAlert = (index) =>
        Alert.alert(
            "Delete Task?",
            "Are you sure you want to delete this Task?",
            [
                {
                    text: "Cancel",
                    onPress: () => console.log("Cancel Pressed"),
                    style: "cancel"
                },
                {
                    text: "Yes", onPress: () => {
                        completeTask(index);
                        console.log("OK Pressed")
                    }
                }
            ],
            {cancelable: false}
        );

    return (
        <View style={styles.container}>
            {/* Added this scroll view to enable scrolling when list gets longer than the page */}
            <ScrollView
                contentContainerStyle={{
                    flexGrow: 1
                }}
                keyboardShouldPersistTaps='handled'
            >

                {/* Today's Tasks */}
                <View style={styles.tasksWrapper}>
                    <Text style={{...FONTS.h1, color: COLORS.white}}>Today's tasks</Text>
                    <View style={styles.items}>
                        {/* This is where the tasks will go! */}
                        {
                            taskItems.map((item, index) => {
                                return (
                                    <TouchableOpacity key={index} onPress={() => {
                                        Haptics.notificationAsync(Haptics.NotificationFeedbackType.Error)
                                        createTwoButtonAlert(index)
                                    }}>
                                        <Task text={item}/>
                                    </TouchableOpacity>
                                )
                            })
                        }
                    </View>
                </View>

            </ScrollView>

            {/* Write a task */}
            {/* Uses a keyboard avoiding view which ensures the keyboard does not cover the items on screen */}
            <KeyboardAvoidingView
                behavior={Platform.OS === "ios" ? "padding" : "height"}
                style={styles.writeTaskWrapper}
            >
                <TextInput style={styles.input} placeholder={'Write a task'} value={task}
                           onChangeText={text => setTask(text)}/>
                <TouchableOpacity onPress={() => {
                    Haptics.notificationAsync(Haptics.NotificationFeedbackType.Warning)
                    handleAddTask()
                }}>
                    <View style={styles.addWrapper}>
                        <Text style={styles.addText}>+</Text>
                    </View>
                </TouchableOpacity>
            </KeyboardAvoidingView>

        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: COLORS.black,
    },
    tasksWrapper: {
        paddingTop: 80,
        paddingHorizontal: 20,
    },
    sectionTitle: {
        color: COLORS.white,
        fontSize: 24,
        fontWeight: 'bold'
    },
    items: {
        marginTop: 100,
    },
    writeTaskWrapper: {
        position: 'absolute',
        top: 130,
        width: '100%',
        flexDirection: 'row',
        justifyContent: 'space-around',
        alignItems: 'center'
    },
    input: {
        paddingVertical: 15,
        paddingHorizontal: 15,
        backgroundColor: COLORS.white,
        borderRadius: 60,
        borderColor: COLORS.primary,
        borderWidth: 2,
        width: 250,
    },
    addWrapper: {
        width: 60,
        height: 60,
        backgroundColor: COLORS.white,
        borderRadius: 60,
        justifyContent: 'center',
        alignItems: 'center',
        borderColor: COLORS.primary,
        borderWidth: 2,
    },
    addText: {},
});