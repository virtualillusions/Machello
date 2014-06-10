/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vi.machello.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A Logger object is used to log messages for a specific system or application
 * component. Loggers are normally named, using a hierarchical dot-separated
 * namespace. Logger names can be arbitrary strings, but they should normally be
 * based on the package name or class name of the logged component, such as
 * java.net or javax.swing. In addition it is possible to create "anonymous"
 * Loggers that are not stored in the Logger namespace. <p> Logger objects may
 * be obtained by calls on one of the getLogger factory methods. These will
 * either create a new Logger or return a suitable existing Logger. It is
 * important to note that the Logger returned by one of the {@code getLogger}
 * factory methods may be garbage collected at any time if a strong reference to
 * the Logger is not kept. <p> Logging messages will be forwarded to registered
 * Handler objects, which can forward the messages to a variety of destinations,
 * including consoles, files, OS logs, etc. <p> Each Logger keeps track of a
 * "parent" Logger, which is its nearest existing ancestor in the Logger
 * namespace. <p> Each Logger has a "Level" associated with it. This reflects a
 * minimum Level that this logger cares about. If a Logger's level is set to
 * <tt>null</tt>, then its effective level is inherited from its parent, which
 * may in turn obtain it recursively from its parent, and so on up the tree. <p>
 * The log level can be configured based on the properties from the logging
 * configuration file, as described in the description of the LogManager class.
 * However it may also be dynamically changed by calls on the Logger.setLevel
 * method. If a logger's level is changed the change may also affect child
 * loggers, since any child logger that has <tt>null</tt> as its level will
 * inherit its effective level from its parent. <p> On each logging call the
 * Logger initially performs a cheap check of the request level (e.g., SEVERE or
 * FINE) against the effective log level of the logger. If the request level is
 * lower than the log level, the logging call returns immediately. <p> After
 * passing this initial (cheap) test, the Logger will allocate a LogRecord to
 * describe the logging message. It will then call a Filter (if present) to do a
 * more detailed check on whether the record should be published. If that passes
 * it will then publish the LogRecord to its output Handlers. By default,
 * loggers also publish to their parent's Handlers, recursively up the tree. <p>
 * Each Logger may have a ResourceBundle name associated with it. The named
 * bundle will be used for localizing logging messages. If a Logger does not
 * have its own ResourceBundle name, then it will inherit the ResourceBundle
 * name from its parent, recursively up the tree. <p> Most of the logger output
 * methods take a "msg" argument. This msg argument may be either a raw value or
 * a localization key. During formatting, if the logger has (or inherits) a
 * localization ResourceBundle and if the ResourceBundle has a mapping for the
 * msg string, then the msg string is replaced by the localized value. Otherwise
 * the original msg string is used. Typically, formatters use
 * java.text.MessageFormat style formatting to format parameters, so for example
 * a format string "{0} {1}" would format two parameters as strings. <p> When
 * mapping ResourceBundle names to ResourceBundles, the Logger will first try to
 * use the Thread's ContextClassLoader. If that is null it will try the
 * SystemClassLoader instead. As a temporary transition feature in the initial
 * implementation, if the Logger is unable to locate a ResourceBundle from the
 * ContextClassLoader or SystemClassLoader the Logger will also search up the
 * class stack and use successive calling ClassLoaders to try to locate a
 * ResourceBundle. (This call stack search is to allow containers to transition
 * to using ContextClassLoaders and is likely to be removed in future versions.)
 * <p> Formatting (including localization) is the responsibility of the output
 * Handler, which will typically call a Formatter. <p> Note that formatting need
 * not occur synchronously. It may be delayed until a LogRecord is actually
 * written to an external sink. <p> The logging methods are grouped in five main
 * categories: <ul> <li><p> There are a set of "log" methods that take a log
 * level, a message string, and optionally some parameters to the message
 * string. <li><p> There are a set of "logp" methods (for "log precise") that
 * are like the "log" methods, but also take an explicit source class name and
 * method name. <li><p> There are a set of "logrb" method (for "log with
 * resource bundle") that are like the "logp" method, but also take an explicit
 * resource bundle name for use in localizing the log message. <li><p> There are
 * convenience methods for tracing method entries (the "entering" methods),
 * method returns (the "exiting" methods) and throwing exceptions (the
 * "throwing" methods). <li><p> Finally, there are a set of convenience methods
 * for use in the very simplest cases, when a developer simply wants to log a
 * simple string at a given log level. These methods are named after the
 * standard Level names ("severe", "warning", "info", etc.) and take a single
 * argument, a message string. </ul> <p> For the methods that do not take an
 * explicit source name and method name, the Logging framework will make a "best
 * effort" to determine which class and method called into the logging method.
 * However, it is important to realize that this automatically inferred
 * information may only be approximate (or may even be quite wrong!). Virtual
 * machines are allowed to do extensive optimizations when JITing and may
 * entirely remove stack frames, making it impossible to reliably locate the
 * calling class and method. <P> All methods on Logger are multi-thread safe.
 * <p> <b>Subclassing Information:</b> Note that a LogManager class may provide
 * its own implementation of named Loggers for any point in the namespace.
 * Therefore, any subclasses of Logger (unless they are implemented in
 * conjunction with a new LogManager class) should take care to obtain a Logger
 * instance from the LogManager class and should delegate operations such as
 * "isLoggable" and "log(LogRecord)" to that instance. Note that in order to
 * intercept all logging output, subclasses need only override the
 * log(LogRecord) method. All the other logging methods are implemented as calls
 * on this log(LogRecord) method.
 *
 * @author Kyle D. Williams
 */
public interface AppLogger {

    public final Logger log = LoggerFactory.getLogger(AppLogger.class.getName());
}