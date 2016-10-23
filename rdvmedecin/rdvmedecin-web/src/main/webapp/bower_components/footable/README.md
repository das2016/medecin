# FooTable V3 #

This is a complete re-write of the plugin. There is no upgrade path from V2 to V3 at present as the options and the way the code is written are inherently different. Please check out the full documentation for V3 found in the docs folder or by viewing it [online here](http://fooplugins.github.io/FooTable/).

# Changelog #

### 3.1.2

- Added `sortValue` column option. This option allows you to supply your own function to retrieve the sort value for a cell.
- Updated filtering component internals to clean things up a bit.
- Updated filtering component search input to trigger a filtering operation on paste.
- Updated `FooTable.Filtering#addFilter` method to accept an object or `FooTable.Filter` as the first argument to make custom filters easier to implement.
- Updated filtering `preinit` and `init` to return a promise to make custom filters easier to implement.
- Updated `FooTable.Filter` to accept a `FooTable.Query` as the query parameter along with the original plain string.
- Updated paging component to expose some previously private properties to make setting a custom count label element easier.
- Fixed issue where the filtering components `min` option was not being applied.
- Fixed the paging components' `countFormat` option placeholder `{TR}` to correctly reflect filtered rows.
- Fixed preinit unhandled exception if the `table` the plugin is initialized on has no `class` attribute.
- Fixed issue with the individual components .ZIP missing the `footable.core.bootstrap.min.css` and `footable.core.standalone.min.css` minified files.

### 3.1.1

- Added the `breakpoint` class to the table when columns are hidden.
- Added an internal key used as part of the storage keys generated by the state component. Can be changed if an update breaks backwards compatibility.
- Added the `hidden` option that can be used for filters. When set to true the filter is always applied to the table, can not be cleared unless removed using the `FooTable.Filtering#removeFilter()` method and they will not effect the default UI search/clear buttons.
- Updated some utility functions with additional parameter checking to avoid unhandled errors under certain scenarios.
- Updated the `FooTable.Filtering#addFilter()` method to expose the last three parameters of the `FooTable.Filter` constructor; ignoreCase, connectors and space.
- Fixed an issue when reinitializing the plugin for a second time on a table after it's DOM had been modified by a 3rd party.
- Fixed an issue where the `FooTable.Filtering#draw()` method was not setting the button to the clear icon if the filter supplied was not the default.
- Fixed state component clearing filters supplied through options if the state value was an empty array.
- Fixed an issue with the incorrect sort icon appearing if a column was set to just `sorted=true` without supplying a direction.

----------

### 3.1.0

- Added a new state component that handles the page number, sorted column and any filters applied across sessions.
- Added in the ability to toggle the visibility of the various editing component buttons.
- Added in a new "view" button to the editing component.
- Added in `FooTable.Rows#expand()` and `FooTable.Rows#collapse()` methods to toggle all visible rows.
- Added in a new `FooTable.getRow()` utility method to retrieve the current `FooTable.Row` object given a `TR` element or any of its' children.
- Fixed an issue when reinitializing the plugin by doing some additional cleanup in the destroy methods for columns, rows and sorting.
- Fixed an issue with filtering not applying correctly when filters were supplied through the options.
- Fixed base `FooTable.Component` method signatures.
- Updated the `FooTable.Row#val()` method to merge supplied data instead of replacing it entirely.
- Updated the `FooTable.getFnPointer()` method to handle dot notation names.
- Updated the requirement checks for columns so having at least one `data-breakpoints` attribute is no longer required.
- Updated the `FooTable.Filtering#filter()` method to only apply all filters in the `FooTable.Filtering#filters`.
- Removed the `FooTable.Table#applyFilter()` and `FooTable.Table#removeFilter()` methods.
- Removed the `FooTable.components.core` and `FooTable.components.internal` objects.

**NOTE**

As of version 3.1.0 there are some backwards compatibility issues if you have done customizations like those seen in the [custom dropdown filter](http://fooplugins.github.io/FooTable/docs/examples/advanced/filter-dropdown.html) example using the 3.0.x versions. The examples have been updated with the changes however the issues are listed below.

1. The `FooTable.Filtering#filter()` method no longer accepts any arguments and is used purely to apply all filters found in the `FooTable.Filtering#filters` array.
2. Due to #1 above to apply a new search filter it must now be done using the `FooTable.Filtering#addFilter(name, query, columns)` method using a name of "search".
3. The internal, core and custom component arrays that existed within the `FooTable.Table#components` object have been removed. All components are now loaded into a single array.
4. When registering a component you now only need to use `FooTable.components.register()` method instead of having to decide between `FooTable.components.register()`, `FooTable.components.core.register()` and `FooTable.components.internal.register()` due to #3 above.

----------

### 3.0.11

- Added in a basic expandAll option for rows.
- Added in a `FooTable.Rows#load()` method to make supplying the table with new data much easier.
- Added in a redraw parameter to the `FooTable.Rows#add()`,`FooTable.Rows#update()` and `FooTable.Rows#delete()` methods to allow for better bulk operations.
- Added in new ignoreCase option for the filtering component.
- Fixed issue with breakpoints being calculated incorrectly on mobile devices.
- Fixed issue with the sorting component preventing the default action of click events from taking place. (think checkboxes not checking when in header)
- Fixed issue where the events `expand.ft.row` and `collapse.ft.row` were not supplying the row as a parameter.

----------

### 3.0.10

- Added the ability to filter for empty values.
- Fixed an issue where there were duplicate components being loaded when using the `FooTable.init()` constructor.
- Fixed an issue where the `FooTable.NumberColumn#thousandSeparator` was being initialized with an incorrect default value.
- Fixed an issue where the old instance id class was being left on the table when reinitializing FooTable on the same table over and over again.

----------

### 3.0.9

- Added in `ready.ft.table` and `postinit.ft.table` events.
- Added new `FooTable.Table#_construct()` method to allow for easier overriding.
- Added in three new methods for the sorting component; `FooTable.Sorting#toggleAllowed(state)`, `FooTable.Sorting#hasChanged()` and `FooTable.Sorting#reset()`.
- Fixed an issue where the sort direction for a column marked as sorted was defaulting to DESC instead of ASC.
- Fixed an issue where the `indexOrRow` parameter for the `FooTable.Row#delete()` and `FooTable.Row#update()` methods was being ignored.

----------

### 3.0.8

- Added a new editing component that provides the framework to create an editable table.
- Added in a new option `toggleSelector` to allow filtering of row click events.
- Added in a priority to component loading.
- Added in new events `expand.ft.row` and `collapse.ft.row`.
- Fixed an issue with the paging component where if the total number of rows was less than the page size breakpoints would not fire.
- Fixed an issue with the paging component during resizing/drawing when there was only a single page.
- Fixed an issue with bubbled errors and deferreds in `FooTable.Table`.
- Fixed the sorting components icon padding on `TH` elements being overridden by Bootstrap.
- Fixed breakpoint values being off by 1 pixel.

----------