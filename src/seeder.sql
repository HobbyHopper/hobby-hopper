use hobby_hopper;

INSERT INTO events (event_name, event_description,  start_date_time, category_id, is_age_restricted, is_public, rsvp_able) VALUES
        ('really cool event','an event that is super awesome and cool',20220512, 1, false, false, true),
        ('Not RSVPable','I\'m creating this event to see if the RSVP button shows up. It shouldn\'t since the event property rsvpAble is set to false. ',20220512, 1, false, false, false)
